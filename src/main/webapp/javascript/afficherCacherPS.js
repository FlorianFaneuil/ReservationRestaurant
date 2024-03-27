function togglePasswordVisibility() {
    var passwordInput = document.getElementById("password");
    var passwordEye = document.querySelector(".password-eye");

    if (passwordInput.type === "password") {
        passwordInput.type = "text";
        passwordEye.style.backgroundImage = "url('${pageContext.request.contextPath }/img/oeilFerme.png')"; 
      
    } else {
        passwordInput.type = "password";
        passwordEye.style.backgroundImage = "url('${pageContext.request.contextPath }/img/oeil(1).png')";
    }
}
