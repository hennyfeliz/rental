

import './Header.css'
import { Avatar, Link } from 'tdesign-react';
import electricity from '../../assets/icons/electricity.svg'
import user from '../../assets/icons/user2.svg'

const Header = () => {
  return (
    <header>
      <div>
        <Link theme="default" hover="underline">
          <img
            src={electricity}
            alt='electricity-icon'
            style={{ width: '42px', height: '42px', marginTop: '10px' }}
          />
        </Link>
      </div>
      <div className="header-central">
        <Link theme="default" hover="underline">
          Products
        </Link>
        <Link theme="default" hover="underline">
          Services
        </Link>
        <Link theme="default" hover="underline">
          Contacts
        </Link>
      </div>
      <div className="header-right">
        <Link theme="default" hover="underline">
          <img
            src={user}
            alt='electricity-icon'
            style={{ width: '34px', height: '34px', padding: '8px', }}
          />
        </Link>
      </div>
    </header>
  )
}

export default Header