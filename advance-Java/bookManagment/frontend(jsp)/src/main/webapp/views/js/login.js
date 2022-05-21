function validate(){
    if((validateUserName() && validatePassword())==true)
    {
        return true;
    }
    return false;
}

function validateUserName() {
  var userName = document.getElementById("userName").value;
  if (userName.length < 3 || userName.length > 50) {
    alert("Length of userName must be between 3 and 50 ");
    return false;
  }
  return true;
}

function validatePassword() {
  var password = document.getElementById("password").value;
  if (password.length < 3 || password.length > 50) {
    alert("Length of password must be between 3 and 50 ");
    return false;
  }
  return true;
}
