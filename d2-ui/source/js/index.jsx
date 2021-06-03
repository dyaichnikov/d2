import React from 'react';
import ReactDOM from 'react-dom';

import '../sass/style.scss';

import Header from './blocks/site-blocks/header/header';
import Main from './blocks/site-blocks/main/main';
import Footer from './blocks/site-blocks/footer/footer';

const root = document.getElementById('root');

function App() {
  return (
    <>
      <Header />
      <Main />
      <Footer />
    </>
  );
}

ReactDOM.render(<App />, root);
