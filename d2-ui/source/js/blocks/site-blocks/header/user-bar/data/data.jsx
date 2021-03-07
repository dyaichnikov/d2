import React from 'react';

import HomeIcon from '../../../../svg/home-icon/home-icon';
import SendIcon from '../../../../svg/send-icon/send-icon';
import ExploreIcon from '../../../../svg/explore-icon/explore-icon';
import FavoriteIcon from '../../../../svg/favorite-icon/favorite-icon';
import UserAccountIcon from '../../../../svg/user-account-icon/user-account-icon';

const data = [
  {
    title: 'To home',
    href: '/home',
    ico: <HomeIcon />,
  },
  {
    title: 'Send message',
    href: '/messages',
    ico: <SendIcon />,
  },
  {
    title: 'Explore',
    href: '/explore',
    ico: <ExploreIcon />,
  },
  {
    title: 'Your favorites',
    href: '/favorites',
    ico: <FavoriteIcon />,
  },
  {
    title: 'To your page',
    href: '/user',
    ico: <UserAccountIcon />,
  },
];

export default data;
