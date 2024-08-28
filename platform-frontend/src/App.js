import React, { useState } from 'react';
import MarkdownIt from 'markdown-it';
import MdEditor from 'react-markdown-editor-lite';
import 'react-markdown-editor-lite/lib/index.css';

const mdParser = new MarkdownIt();

function App() {
    const [markdownContent, setMarkdownContent] = useState('');

    // 当编辑器内容变化时的处理函数
    const handleEditorChange = ({ text }) => {
        setMarkdownContent(text);
    };

    // 发送Markdown内容到后端的函数
    const sendMarkdownToBackend = async () => {
        try {
            const qa = {

                questioncontent: markdownContent, // 这里将Markdown内容作为问题内容
                askerid: 2
            };

            const response = await fetch('/qa', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded',
                },
                body: new URLSearchParams(qa).toString(),
            });

            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }

            const result = await response.text();
            alert('Markdown内容已成功保存到后端。');
        } catch (error) {
            console.error('Error sending markdown to backend:', error);
            alert('保存Markdown内容到后端时发生错误。');
        }
    };

    return (
        <div>
            <MdEditor
                style={{ height: '500px' }}
                renderHTML={(text) => mdParser.render(text)}
                onChange={handleEditorChange}
            />
            <button onClick={sendMarkdownToBackend}>保存Markdown到后端</button>
        </div>
    );
}

export default App;
