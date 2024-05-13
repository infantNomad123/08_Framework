const studentList = document.querySelector("#studentList");
const selectAll = document.querySelector("#selectAll");



selectAll.addEventListener("click", () => {

    studentList.innerHTML = '';
    fetch("index")
    .then(response => response.json())
    .then(result => {
      
        
        result.forEach(student => {
            const row = document.createElement("tr");
            console.log(student);
            for(key in student) {
                        const cell = document.createElement('td');
                        cell.textContent = student[key];
                        row.appendChild(cell);
            }

            studentList.appendChild(row);
        })


    })
})


