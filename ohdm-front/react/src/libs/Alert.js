import React, { Component } from 'react';
import { ToastContainer, toast, Flip } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

class Alert extends Component {

    static show (value, type = 'info') {

        if (typeof value !== 'string') {
            value = value.toString();
        }

        toast[type](value);
    }

    render () {
        return (
            <React.Fragment>
                <ToastContainer autoClose={6000} position={toast.POSITION.BOTTOM_RIGHT} transition={Flip} />
            </React.Fragment>
        )
    }
}

export default Alert;
