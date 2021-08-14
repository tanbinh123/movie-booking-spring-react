import Flickity from 'react-flickity-component';
import 'flickity/css/flickity.css';

const Carousel = (props) => {

    //options from: https://flickity.metafizzy.co/options.html
    const flickityOptions = {
        draggable: false,
        autoPlay: false,
        initialIndex: 3, //zero-based index of the initial selected cell
        selectedAttraction: 0.01, //slower effect on change
        friction: 0.15, //slower effect on change,
        imagesLoaded: true, //re-positions cells once their images have loaded
    }    

    return (
        <Flickity
        className={'carousel'} // default ''
        elementType={'div'} // default 'div'
        options={flickityOptions} // takes flickity options {}
        disableImagesLoaded={false} // default false
        reloadOnUpdate // default false
        static // default false
      >
        <img alt="temp" src="https://cdn.shopify.com/s/files/1/0057/3728/3618/products/black-widow_zfz7dkzv_240x360_crop_center.progressive.jpg?v=1606338732"/>
        <img alt="temp" src="https://cdn.shopify.com/s/files/1/0057/3728/3618/products/black-widow_zfz7dkzv_240x360_crop_center.progressive.jpg?v=1606338732"/>
        <img alt="temp" src="https://cdn.shopify.com/s/files/1/0057/3728/3618/products/black-widow_zfz7dkzv_240x360_crop_center.progressive.jpg?v=1606338732"/>
        <img alt="temp" src="https://cdn.shopify.com/s/files/1/0057/3728/3618/products/black-widow_zfz7dkzv_240x360_crop_center.progressive.jpg?v=1606338732"/>
        <img alt="temp" src="https://cdn.shopify.com/s/files/1/0057/3728/3618/products/black-widow_zfz7dkzv_240x360_crop_center.progressive.jpg?v=1606338732"/>
        <img alt="temp" src="https://cdn.shopify.com/s/files/1/0057/3728/3618/products/black-widow_zfz7dkzv_240x360_crop_center.progressive.jpg?v=1606338732"/>

      </Flickity>
    );
}
 
export default Carousel;