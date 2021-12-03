$(function () {
    var receiptId = localStorage.getItem('receiptId');

    $.get(`/receipt?id=${receiptId}`, data => {
        console.log(data);

        var items = $("#items");
        for (var product of data.products) {
            var div = $("<div/>")
                .appendTo(items);
            
            $("<label/>")
                .text(product.count)
                .appendTo(div);

            $("<label/>")
                .appendTo(div);
            $("<label/>")
                .appendTo(div);
            
            $("<label/>")
                .text(product.product.displayName)
                .appendTo(div);

            $("<label/>")
                .appendTo(div);
            $("<label/>")
                .appendTo(div);

            $("<label/>")
                .text("$" + (product.count * product.product.price / 100).toString())
                .appendTo(div);
        }

        $("#subtotal").text(data.subtotal / 100);
        $("#salesTax").text(Math.round(data.taxRate * 10) / 10);
        $("#total").text(Math.round(data.subtotal * (100 + data.taxRate) / 100) / 100);

        $("#paymentMethod").text(data.paymentMethod);
        if (data.paymentMethod !== 'cash') {
            $("#cardNoDigits").text(data.creditCardDigits);
            $("#cardNo").removeClass('hidden');
        }
        else {
            $("#cardNo").addClass('hidden');
        }
    });
});