document.getElementById("tokenbackup").value = localStorage.token;
function myFunction(key) {
    var bodytext;
    if (key == "production") {
        bodytext = document.getElementById("productionSelect").value;
        console.log(bodytext);
    } else {
        bodytext = document.getElementById(key).textContent.trim();
    }
    var content = document.getElementById("edited" + key);
    if (bodytext === "")
        return;
    if (content === null)
        return;
    document.getElementById("edited" + key).value = bodytext;
    document.getElementById("username" + key).value = localStorage.username;

//    console.log(encodeURIComponent(bodytext));
//    console.log(document.getElementById("edited".concat(key)).value);
}
function myFunctionKeypress(e) {
    key = $(e).attr('key');
    value = $(e).attr('valueofkey');
    var bodytext = document.getElementById(key).textContent.trim();
    var res = value.split("|")[0];
    var n = String(bodytext).trim().localeCompare(String(res).trim());
    if (n != 0) {
        document.getElementById("button".concat(key)).className = "w3-btn w3-red";
        document.getElementById("button".concat(key)).disabled = false;
    } else {
        document.getElementById("button".concat(key)).disabled = true;
        document.getElementById("button".concat(key)).className = "w3-btn w3-blue-grey";
    }

}
function changeSelectProduct(key, sel, value) {
    if (sel.value != value) {
        document.getElementById("button".concat(key)).className = "w3-btn w3-red";
        document.getElementById("button".concat(key)).disabled = false;
    } else {
        document.getElementById("button".concat(key)).disabled = true;
        document.getElementById("button".concat(key)).className = "w3-btn w3-blue-grey";
    }
    console.log(sel.value);

}
document.getElementById("username").innerHTML = localStorage.username;