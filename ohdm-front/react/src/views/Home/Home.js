import React, { Component } from 'react';
import { Jumbotron } from 'reactstrap';


class Home extends Component {

    loading = () => <div className="animated fadeIn pt-1 text-center">Loading...</div>

    render() {

        return (
            <div className="animated fadeIn">
                <Jumbotron>
                    <h1 className="display-1" style={{marginBottom: '100px'}}>
                        Witamy w One House That Matters
                    </h1>
                </Jumbotron>
            </div>
        );
    }
}

export default Home;
