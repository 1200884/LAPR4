var AGVcontainer = document.getElementById("agv-info");
var btn = document.getElementById("btn");

btn.addEventListener("click", function () {
    console.log("alfredo");
    var ourRequest = new XMLHttpRequest();
    ourRequest.open('GET', "http://localhost:63342/eapli.base/base/webdashboard.json");
    ourRequest.onload = function (){
            var ourData = JSON.parse(ourRequest.responseText);
            renderHTML(ourData);
    };
    ourRequest.onerror = function () {
        console.log("Connection error");
    };

    ourRequest.send();
});

function renderHTML(data) {
    var htmlString = "";
    for (i = 0; i < data.length; i++) {
        htmlString += "<p>" + data[i].id + " status is " + data[i].status + "location is" + data[i].location + ".</p>";
    }
    AGVcontainer.insertAdjacentHTML('beforeend', htmlString);
    /* var table = document.getElementById('myTable')
     for (var i = 0; i < 20; i++) {
         for (var j = 0; j < 20; j++) {
             var row = `<tr>
                             <td>${data[i].name}</td>
                             <td>${data[i].age}</td>
                             <td>${data[i].birthdate}</td>
                       </tr>`
             table.innerHTML += row
         }
     }*/
}