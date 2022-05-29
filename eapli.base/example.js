var tabledata=[{
    "Id": 123456789,
    "Status": "WORKING",
    "Location": {
        "x": 10,
        "y": 9,
    },
},
    {
        "Id": 123456789,
        "Status": "WORKING",
        "Location": {
            "x": 10,
            "y": 9
        }
}]
for( var i in tabledata){
    var row=<tr>
            <td>{$tabledata[i].Id}</td>
            <td>{$tabledata[i].Status}</td>
            <td>{$tabledata[i].Location[0]}</td>
    </tr>
    var table=$('table-body')
    table.append(row)
}