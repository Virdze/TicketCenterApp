document.getElementById("loginForm").addEventListener("submit", async function (event) {
    event.preventDefault();

    const formData = new FormData(event.target);
    const data = {
        email : formData.get("email"),
        password : formData.get("password")
    };

    try{
        const response = await fetch("http://localhost:8080/api/v1/user/login", {
            method : "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body : JSON.stringify(data)
        });

        if(response.ok){
            const result = await response.json();
            console.log(result);
        } else {
            console.error("Login failed");
        }
    }
    catch (error) {
        console.error("An error occurred", error);
    }
});