$(function () {
    var recId = 0;
    $.get('/receipt/all', (data) => {//goes through every receipt and finds a new id
        data.forEach(item => {
            if(item.id <= recId)
                recId = item.id + 1;
        });
    });

    $.get('/product/all', (data) => {
        data.forEach(item => {
            var itemData = localStorage.getItem(item.id);
            if(itemData != NULL){
                //here we should add the items to the receipt/product relationship table.
                //the receipt id will be var recId seen above
                //item.id will be product id
                //count will be itemData
                //it should also print it in the receipt
            }
        });
    });

    var sql = "INSERT INTO Receipt VALUES ( " + recID + ", '" + Number.parseInt(localStorage.getItem(paymentMethod)) + "', 8.1, " + Number.parseInt(localStorage.getItem(subtotal)) + ", 0, " + Number.parseInt(localStorage.getItem(lastFour)) + ", '2021-12-03')";
    //not 100% sure on how to run this query inot the database?

    //also not sure how to format the printing properly, so here is the data
    //What's needed to print in the receipt page and where it's stored:
    var subTotalPrint = Number.parseInt(localStorage.getItem(subtotal)) / 100;
    var salesTaxPrint = 8.1;
    var totalPrint = (Number.parseInt(localStorage.getItem(subtotal)) / 100) * 1.081;
    if(Number.parseInt(localStorage.getItem(cashPaid)) != 0){
        var cashPrint = Number.parseInt(localStorage.getItem(cashPaid));
        var changePrint = totalPrint - cashPrint;
    }
    var lastDigitPrint = Number.parseInt(localStorage.getItem(lastFour));
});