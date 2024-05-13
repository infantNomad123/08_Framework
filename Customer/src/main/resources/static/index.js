const addBtn = document.querySelector("#addBtn");

const inputName = document.querySelector("#inputName");
const inputTel = document.querySelector("#inputTel");
const inputAddress = document.querySelector("#inputAddress");


const obj ={
  "inputName" : inputName.value,
  "inputTel"  : inputTel.value ,
  "inputAddress" : inputAddress.value 
};

addBtn.addEventListener("submit", () => {
    fetch("main",{
        method : "POST",
        headers : {"Content-Type":"application/json"},
        body : JSON.stringify(obj)
    })
    .then(resp => resp.json())
    .then(result => {
        if(result > 0){
            alert("Insert완료");
            
            
        } else{
            alert("실패");
            
        }

    })
})