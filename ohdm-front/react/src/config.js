const config = (() => {
    if (!process.env.NODE_ENV || process.env.NODE_ENV === 'development') {
        return {
            api: {
                host: 'localhost',
                port: 8080
            }
        }
    } else {
        return {//PROD
            api: {
                host: window.location.host,
                port: 8080
            }
        }
    }
})();


let apiUrl = `//${config.api.host}${config.api.port === 80 ? '' : ':' + config.api.port}/`;

//export {config, apiUrl, token, loginHeader}
export {config, apiUrl}
