// server.js (Node.js와 Express 예제)

const express = require('express');
const bodyParser = require('body-parser');
const app = express();
const port = 3000;

// body-parser 미들웨어
app.use(bodyParser.json());

app.post('/review/regist', (req, res) => {
    const feedback = req.body.feedback;

    // 데이터베이스에 저장하는 코드 작성
    // 예: db.saveFeedback(feedback);

    // 저장이 완료되면 성공 응답
    res.json({ success: true });
});

app.listen(port, () => {
    console.log(`Server running on http://localhost:${port}`);
});