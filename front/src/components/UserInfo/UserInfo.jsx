
import { Link } from 'react-router-dom';
import './UserInfo.css'; // Importa tus estilos CSS
import logout from '../../assets/icons/logout.svg'


const UserInfo = () => {

  return (
    <>
      <div className="user-info" >
        <h2>Information</h2>
        <span>
          User perfil
        </span>
        <span>Past products</span>
        <span>User configuration</span>
        <span>Other</span>
        <hr style={{ margin: "4px 0" }} />
        <Link to={'/login'}>
          <div className="logout-cont">
            <img
              alt='logout-icon'
              src={logout}
              style={{ width: '28px', height: '28px' }}
            />
            <span>Logout</span>
          </div>
        </Link>
      </div>
    </>
  );
}

export default UserInfo