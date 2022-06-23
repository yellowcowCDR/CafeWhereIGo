/**
 * 
 */
function select_profile_photo(){
	var profile_preview = document.getElementById("profile_photo_preview");
	var profile_photo = document.getElementById("profile_photo_file_input");
	profile_photo.click();
}
function on_profile_photo_changed(inputbox){
	var inputbox_id = inputbox.id;
	var inputbox_id_tokens = inputbox_id.split("_");
	var img_id = inputbox_id_tokens[0];
	var preview_img = document.getElementById(img_id+"_img_preview");
	var fReader = new FileReader();
	fReader.readAsDataURL(inputbox.files[0]);
	fReader.onloadend=function(event){
		preview_img.src = event.target.result;
	}
}
function passwordValidation(){
	var user_pw = document.getElementById("user_pw");
	var user_pw_repeat = document.getElementById("user_pw_repeat");
	var pwValidationResult = document.getElementById("pwValidationResult");
	if(user_pw.value=="" && user_pw_repeat.value==""){
		pwValidationResult.style.display="none";
		pwValidationResult.innerText="";
		pw_validated=false;
	}else{
		if(user_pw.value==user_pw_repeat.value){
			pwValidationResult.style.display="none";
			pwValidationResult.innerText="";
			pw_validated=true;
		}else{
			pwValidationResult.style.display="block";
			pwValidationResult.innerText="비밀번호가 일치하지 않습니다.";
			pwValidationResult.style.color="red"
			pw_validated=false;
		}
	}
}
function registerUser(){
	var registerForm = document.getElementById("register_form");
	registerForm.action = "${contextPath}/user/registerUser.do" 
	//var inputFormList = document.getElementsByClass("input_box")
	registerForm.submit();
}