import React from 'react';
import AboutUser from './about-user/about-user';
import UserPublications from './user-publications/user-publications';

export default function User() {
  return (
    <section className="user">
      <h2 className="visually-hidden">User information</h2>
      <AboutUser />
      <UserPublications />
    </section>
  );
}
