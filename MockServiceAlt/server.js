//Swapped this out in favour of a spring service

const express = require('express');
const app = express();
app.use(express.json());

// GET endpoint
app.get('/api/data', (req, res) => {
    res.json({ message: "Hello, World!" });
});

// POST endpoint
app.post('/api/data', (req, res) => {
    const { name } = req.body;
    res.json({ message: `Hello, ${name}!` });
});

app.listen(3000, () => console.log('Server running on http://localhost:3000'))