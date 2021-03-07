import React from 'react';

import Done from '../../../../svg/done-icon/done-icon';

import mock from './mock/mock';

import '../../../../../../img/avatar-placeholder.png';

export default function AboutUser() {
  return (
    <section className="row g-0 about-user">
      <h2 className="visually-hidden">About user</h2>
      <figure className="col-auto about-user__avatar-container">
        <img src="assets/img/avatar-placeholder.png" className="about-user__avatar" title="User avatar" alt="User avatar" />
      </figure>
      {mock.map((userInformation) => (
        <div key="user-information" className="col-12 col-md-auto col-auto about-user__user-information-container">
          <div className="about-user__nickname-container">
            <p className="about-user__user-nickname">{userInformation.nickName}</p>
            {userInformation.verified && <Done />}
          </div>
          {userInformation.accountInformation.map((accInfo) => (
            <ul key="account-statistics-list" className="row row-cols-auto g-0 about-user__account-statistics-list">
              <li key="account-publications" className="about-user__account-statistics-item">
                <b>{accInfo.publicationsCount}</b> - publications
              </li>
              <li key="account-subscribers" className="about-user__account-statistics-item">
                <b>{accInfo.subscribersCount}</b> - subscribers
              </li>
              <li key="account-subscriptions" className="about-user__account-statistics-item">
                <b>{accInfo.subscriptions}</b> - subscriptions
              </li>
            </ul>
          ))}
        </div>
      ))}
    </section>
  );
}
