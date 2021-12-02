$(function () {
    var totalPrice = 0;
    $.get('/product/all', (data) => {
        data.forEach(item => {
            var itemData = localStorage.getItem(item.id);
            if(itemData != NULL){
                totalPrice += item.price * itemData;
            }
        });
    });
    localStorage.setItem('subtotal', totalPrice);
    totalPrice = totalPrice / 100;
    localStorage.setItem('tax', 8.1);
    totalPrice = totalPrice * 1.081;
    localStorage.setItem('total', totalPrice);
    document.getElementById("totalPrice").innerHTML = totalPrice;
});

function checkPay(input){
    if(input.length() == 4 && !isNaN(input)){
        localStorage.setItem('paymentMethod', 'Credit/Debit');
        localStorage.setItem('lastFour', Number.parseInt(input));
        localStorage.setItem('cashPaid', 0);
        location.replace("/receiptPage.html")
    } else {
        document.getElementById('invalid').innerHTML = "Please enter 4 digits";
    }
}

function checkCash(input){
    var total = Number.parseInt(input)
    if(input >= total){
        localStorage.setItem('paymentMethod', 'Cash');
        localStorage.setItem('lastFour', 0);
        localStorage.setItem('cashPaid', Number.parseInt(input));
        location.replace("/receiptPage.html")
    } else {
        document.getElementById('notEnough').innerHTML = "This is not enough";
    }
}
