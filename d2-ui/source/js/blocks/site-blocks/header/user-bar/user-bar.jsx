import React from 'react';

import data from './data/data';

export default function UserBar() {
  return (
    <nav className="col-8 col-md-3 user-bar">
      <ul className="user-bar__list">
        {data.map((icon) => (
          <li key={icon.href} className="user-bar__item">
            <a href={icon.href} className="user-bar__link" title={icon.title}>
              {icon.ico}
            </a>
          </li>
        ))}
      </ul>
    </nav>
  );
}
