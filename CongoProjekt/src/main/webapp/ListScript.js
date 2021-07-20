


var list = document.getElementById('cart');
var lastid = 0;

function addProduct() {
    var firstproduct = document.getElementById('product').value;
    
    
    var entry = document.createElement('li');
    entry.appendChild(document.createTextNode(firstproduct));
    entry.setAttribute('id','item'+lastid);
    entry.setAttribute('data-name',firstproduct);                           //added a data-name attribute for easier access to name

    var removeButton = document.createElement('button');
    removeButton.appendChild(document.createTextNode("remove"));
    removeButton.setAttribute('onClick','removeProduct("'+'item'+lastid+'")');
    entry.appendChild(removeButton);
    lastid+=1;
    list.appendChild(entry);
}


function removeProduct(itemid){
    var item = document.getElementById(itemid);
    list.removeChild(item);
}


