
const customerForm = document.getElementById("customerForm");
const haircutform = document.getElementById("haircutform");
const workerform = document.getElementById("Workerform");
if (customerForm) {
    document.getElementById("customerForm").addEventListener("submit",function(event){
        event.preventDefault();
        const customer={
            customerName:document.getElementById("customerName").value,
            phoneNumber:document.getElementById("phoneNumber").value,
            userId:document.getElementById("userId").value,
            password:document.getElementById("password").value
        };
        
    fetch("http://localhost:8080/addCustomer",{
        method:"POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(customer)
    }).then(response => response.json())
        .then(data => {
            console.log("Success:", data);
            alert("Customer added successfully: " + JSON.stringify(data.data));
        })
        .catch((error) => {
            console.error("Error:", error);
            alert("Error while adding customer.");
        });
    });
}
if (haircutform) {
    document.getElementById("haircutform").addEventListener("submit",function(event){
        event.preventDefault();
        const services={
            serviceName:document.getElementById("serviceName").value,
            price:document.getElementById("price").value,
            duration:document.getElementById("duration").value,
        };
        const workerid = document.getElementById("workerid").value;
    fetch(`http://localhost:8080/addService?workerid=${workerid}`,{
        method:"POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(services)
    }).then(response => response.json())
        .then(data => {
            console.log("Success:", data);
            alert("Services added successfully: " + JSON.stringify(data.data));
        })
        .catch((error) => {
            console.error("Error:", error);
            alert("Error while adding customer.");
        });
    });
}
if (workerform) {
    document.getElementById("Workerform").addEventListener("submit",function(event){
        event.preventDefault();
        const worker={
            title:document.getElementById("title").value
        };
    fetch("http://localhost:8080/addworker",{
        method:"POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(worker)
    }).then(response => response.json())
        .then(data => {
            console.log("Success:", data);
            alert("Worker added successfully: " + JSON.stringify(data.data));
        })
        .catch((error) => {
            console.error("Error:", error);
            alert("Error while adding customer.");
        });
    });
}
    const button = document.getElementById("hairCutBtn")
        if (button) {
            console.log("Haircut button found and event listener attached");
            button.addEventListener("click", function() {
            const appointment={};
            serviceName=button.dataset.service  
            customerContact=button.dataset.contact
            fetch(`http://localhost:8080/addAppointment?serviceName=${encodeURIComponent(serviceName)}&customerContact=${encodeURIComponent(customerContact)}`, {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(appointment)
            })
            .then(response => response.json())
            .then(data => {
                console.log("Success:", data);
                alert("Worker added successfully: " + JSON.stringify(data.data));
            })
            .catch((error) => {
                console.error("Error:", error);
                alert("Error booking appointment");
            })})};
