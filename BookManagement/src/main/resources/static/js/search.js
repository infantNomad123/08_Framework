const searchBooks = document.querySelector("#searchBooks");
const tBody = document.querySelector("#tBody");

searchBooks.addEventListener("click", () => {
	tBody.innerHTML = "";

    fetch("main")
    .then(response => response.json())
    .then(result => {
        const obj = ["bookNo","bookTitle","bookWriter", "bookPrice", "regDate"];
		

		result.forEach((books, index) => {
			const tr = document.createElement("tr");
			obj.forEach((key) => {
				const td = document.createElement("td");
				td.innerHTML = books[key];
				tr.appendChild(td);
        })
		tBody.appendChild(tr);
    })

})
});