
import './Login.css'
import { Input } from 'tdesign-react';
import { LockOnIcon } from 'tdesign-icons-react';
import { localPostData } from '../../utils/postFetching';
import { useState, } from 'react';
import { useNavigate } from 'react-router-dom';
import { toast } from 'sonner'
import userIcon from '../../assets/icons/user-2.svg'

const Login = () => {
  const navigate = useNavigate();
  const [email, emailChanger] = useState('');
  const [password, passwordChanger] = useState('');

  const loginHandler = async () => {
    const response = await localPostData(email, password);
    console.log(response);
    if (response) {
      navigate("/")
      toast.success('logeado correctamente...')
      setData(response)
      localStorage.setItem('token', response.jwtToken)
    } else {
      toast.error('error de credenciales!')
    }
  }

  const [data, setData] = useState([])

  return (
    <div className="login">
      <img
        className='user-icon-img'
        alt='user-icon'
        src={userIcon}
      />
      <Input
        placeholder="Email"
        className="input"
        value={email}
        onChange={(email) => {
          emailChanger(email)
        }}
      />
      <Input
        prefixIcon={<LockOnIcon />}
        placeholder="Password"
        value={password}
        onChange={(password) => {
          passwordChanger(password)
        }}
        type="password"
        className="input"
      />
      <button onClick={loginHandler}>Entrar</button>
    </div>
  )
}


export default Login