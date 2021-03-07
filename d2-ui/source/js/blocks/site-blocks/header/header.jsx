import React from 'react';

import TopBar from './top-bar/top-bar';

export default function Header() {
  return (
    <header className="header">
      <h1 className="visually-hidden">d2</h1>
      <div className="container header__container">
        <TopBar />
      </div>
    </header>
  );
}
