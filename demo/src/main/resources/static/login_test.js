const form = document.getElementById("form");
const username = document.getElementById("usernamme");
const email = document.getElementById("email");
const password = document.getElementById("password");
const password2 = document.getElementById("password2");

form.addEventListener('submit', e => {
    e.preventDefault();
    checkInputs();
})

function checkInputs(){
    const usernameValue = username.value.trim();
    const emailValue = email.value.trim();
    const passwordValue = email.value.trim();
    const passwordValue2 = password2.value.trim();


    if(usernameValue === '')
        setErrorFor(username, 'Username cannot be blank');
    else
        setSuccessFor(username);

    if(emailValue === '')
        setErrorFor(email, 'email cannot be blank');
    else
        setSuccessFor(email);

    if(passwordValue === '')
        setErrorFor(password, 'password cannot be blank');
    else
        setSuccessFor(password);

    if(passwordValue2 === '')
        setErrorFor(password2, 'password2 cannot be blank');
    else
        setSuccessFor(password2);
}

function setErrorFor(input, message){
    const formControl = input.parentElement;
    const small = formControl.querySelector('small');
    formControl.className = 'form-control error';
    small.innerText = message;
}

function setSuccessFor(input){
    const formControl = input.parentElement;
    formControl.className = 'form-control success';
}

