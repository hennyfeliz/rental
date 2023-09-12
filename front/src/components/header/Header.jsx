

import './Header.css'
import house_icon from '../../assets/icons/house.svg'
import user from '../../assets/icons/user_2.svg'
import { Link } from 'tdesign-react';
import { Link as LinkTo } from 'react-router-dom';
import UserInfo from '../UserInfo/UserInfo';
import { useState } from 'react'

const Header = () => {
  const [isHovered, setIsHovered] = useState(false); 

  const handleOpenModal = () => {
    setIsHovered(!isHovered)
  };

  return (
    <>
      <header>
        <div>
          <LinkTo to='/'>
            <Link theme="default" hover="underline">
              <img
                src={house_icon}
                alt='electricity-icon'
                style={{ width: '42px', height: '42px', marginTop: '10px' }}
              />
            </Link>
          </LinkTo>
        </div>
        <div className="header-central">
          <Link theme="default" hover="underline">
            Houses
          </Link>
          <Link theme="default" hover="underline">
            Airbnb
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
              onClick={handleOpenModal}
              style={{ width: '34px', height: '34px', padding: '8px', }}
            />
          </Link>
        </div>
      </header>
      {isHovered && (
        <div>
          <UserInfo />
        </div>
      )}
    </>
  )
}

export default Header