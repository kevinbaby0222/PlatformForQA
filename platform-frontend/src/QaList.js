import React, { Component } from 'react';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';

class QaList extends Component {
    constructor(props) {
        super(props);
        this.state = { qas: [] };
    }

    componentDidMount() {
        fetch('/qa')
            .then(response => response.json())
            .then(data => this.setState({ qas: data }));
    }

    render() {
        const { qas } = this.state;

        const qaList = qas.map(qa => {
            return <tr key={qa.qaid}>
                <td style={{ whiteSpace: 'nowrap' }}>{qa.questioncontent}</td>
                <td>{qa.askerid}</td>
                <td>
                    {/*<ButtonGroup>*/}
                    {/*    <Button color="danger">删除</Button>*/}
                    {/*</ButtonGroup>*/}
                </td>
            </tr>
        });

        return (
            <div>
                <Container fluid>
                    <h3>QA List</h3>
                    <Table className={"mt-4"}>
                        <thead>
                        <tr>
                            <th width={"30%"}>Question Content</th>
                            <th width={"30%"}>Asker ID</th>
                            <th width={"40%"}>Actions</th>
                        </tr>
                        </thead>
                        <tbody>
                        {qaList}
                        </tbody>
                    </Table>
                </Container>
            </div>
        );
    }
}

export default QaList;


// export default (props) => {
//     return <Button color="danger">Danger!</Button>;
// };