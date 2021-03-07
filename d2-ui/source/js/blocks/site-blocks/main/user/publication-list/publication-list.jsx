/* eslint-disable jsx-a11y/no-noninteractive-element-interactions */
/* eslint-disable jsx-a11y/click-events-have-key-events */
import React, { useState } from 'react';

import classNames from 'classnames';

import data from './data/data';

export default function PublicationList() {
  const [activeList, setActiveList] = useState(data[0]);

  function switchList(e) {
    e.preventDefault();
    if (e.target.tagName === 'A') {
      setActiveList(e.target.textContent);
    }
  }

  return (
    <nav className="publication-list">
      <ul className="publication-list__list-type" onClick={switchList}>
        {data.map((type) => (
          <li key={type} className="publication-list__item-type">
            <a href=" " className={classNames('publication-list__link-type', activeList.toUpperCase() === type.toUpperCase() && 'publication-list__link-type--active')}>{type.toUpperCase()}</a>
          </li>
        ))}
      </ul>
    </nav>
  );
}
