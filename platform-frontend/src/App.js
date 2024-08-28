import React, { useState } from 'react';
import MarkdownIt from 'markdown-it';
import MdEditor from 'react-markdown-editor-lite';
import 'react-markdown-editor-lite/lib/index.css';

// 初始化Markdown解析器
const mdParser = new MarkdownIt();

function App() {
    const [markdownContent, setMarkdownContent] = useState('');

    // 处理编辑器内容变化的函数
    const handleEditorChange = ({ html, text }) => {
        console.log('handleEditorChange', html, text);
        setMarkdownContent(text); // 更新状态
    };
    const handleSendToBackend = () => {
        sendToBackend(markdownContent).then(response => {
            console.log('Response from backend:', response);
        }).catch(error => {
            console.error('Error:', error);
        });
    };

    const sendToBackend = async (markdownContent) => {
        // 尝试将markdownContent转换为JSON字符串
        const jsonContent = JSON.stringify({ markdown: markdownContent });

        // 验证JSON字符串是否有效
        try {
            JSON.parse(jsonContent);
        } catch (error) {
            console.error('Error: Invalid JSON content:', error);
            return; // 或者抛出错误，取决于你的需求
        }

        try {
            await fetch('http://localhost:2222/postTestMarkdown', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: jsonContent,
            });
            console.log('Data sent to backend.');
        } catch (error) {
            console.error('Error sending data to backend:', error);
        }
    };




    return (
        <div>
            <MdEditor
                style={{ height: '500px' }}
                renderHTML={text => mdParser.render(text)}
                onChange={handleEditorChange}
            />
            {/* 显示Markdown渲染的HTML */}
            <div
                className="markdown-preview"
                dangerouslySetInnerHTML={{ __html: mdParser.render(markdownContent) }}
            />
            {/* 发送按钮 */}
            <button onClick={handleSendToBackend}>Send to Backend</button>
        </div>
    );
}

export default App;
