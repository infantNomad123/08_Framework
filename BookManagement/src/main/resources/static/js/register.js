const registerBtn = document.querySelector("#registerBtn");
const title = document.querySelector("#title");
const writer = document.querySelector("#writer");
const price = document.querySelector("#price");
registerBtn.addEventListener("click", () => {
    const obj = {
        "bookTitle" : title.value,
        "bookWriter" : writer.value,
        "bookPrice" : price.value
    };

    fetch("/bookManagement/register", {
        method : "POST",
        headers : {"Content-Type":"application/text"},
        body : JSON.stringify(obj)
    }).then(response => response.text())
    .then(result => {
        if(result > 0){
            alert("등록되었습니다");
        }
        return;
    })


});