/* eslint-disable react/prop-types */


import './HouseCard.css'
// import house_img from '../../assets/img/house-img.webp'
import { Row, Col, Button, Divider, Dropdown, MessagePlugin } from 'tdesign-react';
import { ShareIcon, ThumbUpIcon, Icon } from 'tdesign-icons-react';
import Disponibilidad from '../Disponibilidad/Disponibilidad';

const options = [
  {
    content: 'Contactar',
    value: 1,
  },
  {
    content: 'Comprar',
    value: 2,
  },
];

const clickHandler = (data) => {
  MessagePlugin.success(`选中【${data.value}】`);
};
// eslint-disable-next-line react/prop-types
const HouseCard = ({ item }) => {

  function formatCurrency(amount, currencyCode = 'USD', locale = 'en-US') {
    try {
      const formatter = new Intl.NumberFormat(locale, {
        style: 'currency',
        currency: currencyCode,
      });

      return formatter.format(amount);
    } catch (error) {
      console.error('Error formatting currency:', error);
      return '';
    }
  }

  return (
    <div>
      <div className='house-card-zero'>
        <div className='card-head'>
          <div>
            <h3>{`${item.address}`}</h3>
            <span>{`US ${formatCurrency(item.rentalInfo.price)}`}</span>
          </div>
          <div className='dropdown-head-card'>
            <Dropdown options={options} onClick={clickHandler} minColumnWidth="112">
              <Button variant="text" shape="square">
                <Icon name="more" />
              </Button>
            </Dropdown>
          </div>
        </div>
        <div className='card-image'>
          <img src={`data:image/jpeg;base64,${item.image.imgdata}`} alt="house-img" className='house-image-new-card' />
        </div>
        <div className='card-footer'>
          <Row align="middle" justify="center">
            <Col flex="auto" align="middle">
              <Button variant="text">
                <ThumbUpIcon></ThumbUpIcon>
              </Button>
            </Col>
            <Divider layout="vertical"></Divider>
            <Col flex="auto" align="middle">
              <Button variant="text">
                <ShareIcon></ShareIcon>
              </Button>
            </Col>
            <Divider layout="vertical"></Divider>
            <Col flex="auto" align="middle">
              <Button variant="text">
                <Disponibilidad available={item.available} />
              </Button>
            </Col>
          </Row>
        </div>
      </div>
    </div>
  );
}



export default HouseCard