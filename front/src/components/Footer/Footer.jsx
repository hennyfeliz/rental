
import './Footer.css'
import facebook from '../../assets/icons/facebook_.svg'
import twitter from '../../assets/icons/twitter_.svg'
import messenger from '../../assets/icons/messenger_svg.svg'
import instagram from '../../assets/icons/instagram_.svg'

const Footer = () => {
  return (
    <footer>
      <div>
        <img
          src={facebook}
          alt='facebook-icon'
          style={{ width: '24px', height: '24px', padding: '8px', }}
        />
        <span>
          Facebook
        </span>
      </div>
      <div>
        <img
          src={twitter}
          alt='twitter-icon'
          style={{ width: '24px', height: '24px', padding: '8px', }}
        />
        <span>
          Twitter
        </span>
      </div>
      <div>
        <img
          src={messenger}
          alt='messenger-icon'
          style={{ width: '24px', height: '24px', padding: '8px', }}
        />
        <span>
          Messenger
        </span>
      </div>
      <div>
        <img
          src={instagram}
          alt='instagram-icon'
          style={{ width: '24px', height: '24px', padding: '8px', }}
        />
        <span>
          Instagram
        </span>
      </div>
    </footer>
  )
}

export default Footer