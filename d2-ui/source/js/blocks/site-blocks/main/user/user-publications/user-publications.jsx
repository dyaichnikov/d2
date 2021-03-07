import React from 'react';

import PublicationList from '../publication-list/publication-list';

import CommentIcon from '../../../../svg/comment-icon/comment-icon';
import FavoriteIcon from '../../../../svg/favorite-icon/favorite-icon';

import data from './data/data';

import '../../../../../../img/photo-placeholder.png';

export default function UserPublications() {
  return (
    <section className="user-publications">
      <h2 className="visually-hidden">List of user publications</h2>
      <PublicationList />
      <ul className="row row-cols-auto row-cols-md-3 gx-2 gx-md-4 gy-3 user-publications__list">
        {data.map((publication) => (
          <li key={publication.id} className="user-publications__item">
            <a href=" " className="user-publications__link">
              <img src="assets/img/photo-placeholder.png" className="user-publications__publication" alt="Publication" />
              <div className="user-publications__post-stats-container">
                <p className="user-publications__stats"><FavoriteIcon /> {publication.likes}</p>
                <p className="user-publications__stats"><CommentIcon /> {publication.comments}</p>
              </div>
            </a>
          </li>
        ))}
      </ul>
    </section>
  );
}
