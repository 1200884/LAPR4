var AGVcontainer = document.getElementById("agv-info");
var btn = document.getElementById("btn");

btn.addEventListener("click", function() {
    var ourRequest = new XMLHttpRequest();
    ourRequest.open('GET', 'jetbrains://idea/navigate/reference?project=eapli.base&path=webdashboard.json');
    ourRequest.onload = function() {
        if (ourRequest.status >= 200 && ourRequest.status < 400) {
            var ourData = JSON.parse(ourRequest.responseText);
            renderHTML(ourData);
        } else {
            console.log("We connected to the server, but it returned an error.");
        }};

    ourRequest.onerror = function() {
        console.log("Connection error");
    };

    ourRequest.send();
});

function renderHTML(data) {
    var htmlString = "";

    for (i = 0; i < data.length; i++) {
        htmlString += "<p>" + data[i].id + " status is " + data[i].status +"location is"+ data[i].location+  ".</p>";
    }
    AGVcontainer.insertAdjacentHTML('beforeend', htmlString);
}
//tratar do erro do x e y nas us ja feitas