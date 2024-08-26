import React, {Component} from 'react';
import logo from './logo.svg';
import './App.css';

class App extends Component {

    state = {
        qas: []
    };

    async componentDidMount() {
        const response = await fetch('/qa');
        const body = await response.json();
        this.setState({qas: body});
    }

    render() {
        const {qas} = this.state;
        return (
            <div className="App">
                <header className="App-header">
                    <img src={logo} className="App-logo" alt="logo"/>
                    <h3 className="App-title">QA总览</h3>
                    {qas.map(qa =>
                        <div key = {qa.qaid}>
                            {qa.questioncontent} ({qa.askerid})
                        </div>
                    )}
                </header>
                <p className="App-intro">
                    To get started, edit <code>src/App.js</code> and save to reload.
                </p>
            </div>
        );
    }
}

export default App;