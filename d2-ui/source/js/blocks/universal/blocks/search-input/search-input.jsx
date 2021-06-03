import React, { useState } from 'react';

import '../../../../../img/svg/search.svg';

export default function SearchInput() {
  const [searchText, setSearchText] = useState('');

  function changeHandler(e) {
    e.preventDefault();
    setSearchText(e.target.value);
  }

  return (
    <section className="col-4 col-md-3 search-input">
      <h2 className="visually-hidden">Search field</h2>
      <form method="GET" className="search-input__form">
        <input type="text" className="search-input__input" onChange={changeHandler} placeholder="Search" value={searchText} />
      </form>
    </section>
  );
}
