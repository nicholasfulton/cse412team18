const taxRate = 8.1;
const discount = 0;

var subtotal = 0;
var total = 0;

var receiptProducts = [];

$(function () {
    $("#checkout").click(checkout);
    $("#paymentMethod").change(paymentMethodChanged);

    var products = JSON.parse(localStorage.getItem('products') || '{}');
    if (Object.keys(products).length > 0) {
        var productIds = Object.keys(products);
        for (let productId of productIds) {
            receiptProducts.push(products[productId]);
            subtotal += products[productId].count * products[productId].product.price;
        }

        var taxMultiplier = (100 + taxRate) / 100;
        total = Math.round(subtotal * taxMultiplier);

        $("#subtotal").text(subtotal / 100);
        $("#total").text(total / 100);
    }
    else {
        alert('You must select products to continue');
        window.location.href = "/products.html";
    }
});

function paymentMethodChanged() {
    if ($("#paymentMethod").val() === 'card') {
        $("#cardContainer").removeClass('hidden');
    }
    else {
        $("#cardContainer").addClass('hidden');
    }
}

function checkout() {
    var paymentMethod = $("#paymentMethod").val();
    var receipt = {
        id: 0,
        paymentMethod,
        taxRate,
        subtotal,
        discount,
        products: receiptProducts,
        members: [],
        creditCardDigits: undefined,
        saleDate: new Date().toISOString()
    };

    if (paymentMethod === 'card') {
        var digitsText = $("#cardDigitsInput").val();
        if (digitsText) {
            var digits = Number.parseInt(digitsText);
            if (0 <= digits && digits <= 9999) {
                receipt.creditCardDigits = digits;
            }
            else {
                alert('Enter a number between 0 and 9999');
                return;
            }
        }
        else {
            alert('Enter credit card digits');
            return;
        }
    }

    $.get('/receipt/next', nextId => {
        if (nextId) {
            receipt.id = Number.parseInt(nextId);

            console.log(receipt);

            $.ajax({
                type: "POST",
                url: "/receipt",
                data: JSON.stringify(receipt),
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                success: data => {
                    console.log(data);
                },
                error: err => {
                    console.log(err);
                }
            });
        }
    });
}
