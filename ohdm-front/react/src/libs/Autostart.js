import { Storage } from './Libs';

const theme = () => {
    let skin = Storage.read('skin')

    if (skin) {
        document.querySelector('body').classList.add(skin);
    }
}

class Autostart {


    constructor () {
        theme();
    }
}


export default Autostart;
