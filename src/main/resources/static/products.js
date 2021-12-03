$(function () {
    localStorage.removeItem('products');

    $.get('/product/all', (data) => {
        var tbody = $('#products');
        data.forEach(item => {
            var tr = $('<tr/>')
                .appendTo(tbody);
            var td = $('<td/>')
                .text(item.displayName + " ")
                .appendTo(tr);
            var td = $('<td/>')
                .text(item.price/100 + " ")
                .appendTo(tr);
            var td = $('<td>')
                .text(item.stockCount + " ")
                .appendTo(tr);

            var td = $('<td/ style="text-align: center">')
                .appendTo(tr);

            $('<a/>')
                .text("Add")
                .attr("href", "#")
                .click(item, click)
                .appendTo(td);
           
        });
    });
});

function click(event) {
    var productsString = localStorage.getItem('products') || '{}';
    var products = JSON.parse(productsString);
    if (products[event.data.id.toString()]) {
        products[event.data.id.toString()].count++;
    }
    else {
        products[event.data.id.toString()] = {
            count: 1,
            product: event.data
        };
    }

    localStorage.setItem('products', JSON.stringify(products));

    console.log(localStorage.getItem('products'));
}