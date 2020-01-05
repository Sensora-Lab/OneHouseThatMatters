import React, { Component } from 'react';
import { Col, Row, Card, CardHeader, CardBody, Button } from 'reactstrap';


class Popup extends Component {

	close () {
		document.querySelector('.popup').classList.remove('open');
	}

	static open () {
		document.querySelector('.popup').classList.add('open');
	}

	scroll () {
		return (window.scrollY + 0) + 'px';
	}

	render () {
		return (
			<div className='popup'>
				<div className="background" onClick={this.close}></div>
				<div className="content" style={{top: this.scroll()}}>
					<Row>
						<Col xs='12'>
							<Card>
								<CardHeader>
									{this.props.title ? this.props.title : 'Popup'}
									<div className="float-right">
			                            <Button
			                                onClick={this.close}
			                                style={{marginTop: '-12px', marginBottom: '-10px', color: '#fff'}}>
			                                <i className="fa fa-times"></i>
			                            </Button>
			                        </div>
								</CardHeader>
								<CardBody>
									{this.props.content}
								</CardBody>
							</Card>
						</Col>
					</Row>
				</div>
			</div>
		);
	}
}

export default Popup;
