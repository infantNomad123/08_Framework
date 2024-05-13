const images = document.querySelectorAll(".image");
const container = document.querySelector("#container");
let slideIndex = 0;




setInterval(() => {
    for(let i = 0; i<images.length; i++){
        images[i].style.display = "none";
    }
    slideIndex++;
    if(slideIndex > images.length){
        slideIndex=1;
    }
   images[slideIndex-1].style.display = "block";
},2000)

