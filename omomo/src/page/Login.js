import "./Login.css";
import btnGoogle from "../asset/google_signin_buttons/web/1x/btn_google_signin_light_normal_web.png";
import btnKakao from "../asset/kakao_login/en/kakao_login_medium_narrow.png";


function Login(){
  return(
    <div>
      <h1>omomo</h1>
      <button
        className = "btn">
        <img
            className ="button-img"
            src={btnGoogle} alt='누르셈'/>
      </button>

      <button
          className = "btn">
        <img
            className ="button-img"
            src={btnKakao}/>
      </button>
    </div>
  );
}

export default Login;