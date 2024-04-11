const searchBooks = document.querySelector("searchBooks");

searchBooks.addEventListener("click", () => {

    fetch("/main")
    .then(response => response.json())
    .then(result => {
        const obj = ["bookNo","bookName","bookWriter", "bookPrice", "regDate" ]
		

		result.forEach((books, index) => {
			const tr = document.createElement("tr");
			obj.forEach((key) => {
				const td = document.createElement("td");
				td.innerHTML = books[key];
				if(td.innerHTML = "" ){
					td.append(document.createElement("button"));
				}
				tr.append(td);
            
            
        })
    })

})
});