import React from 'react';

import Logo from '../../../universal/blocks/logo/logo';
import SearchInput from '../../../universal/blocks/search-input/search-input';
import UserBar from '../user-bar/user-bar';

export default function TopBar() {
  return (
    <section className="row g-0 top-bar">
      <h2 className="visually-hidden">Top bar</h2>
      <Logo />
      <SearchInput />
      <UserBar />
    </section>
  );
}
