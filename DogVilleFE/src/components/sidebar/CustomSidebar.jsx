import { useState } from 'react';
import SideNav, { Toggle, NavItem, NavIcon, NavText } from '@trendmicro/react-sidenav';
import '@trendmicro/react-sidenav/dist/react-sidenav.css';

function CustomSidebar() {
  const [openMenu, setOpenMenu] = useState(null);
  const [isExpanded, setIsExpanded] = useState(false);

  const toggleMenu = (menuName) => {
    if (isExpanded) setOpenMenu((prevMenu) => (prevMenu === menuName ? null : menuName));
  };

  const handleToggle = (expanded) => {
    setIsExpanded(expanded);
    if (!expanded) setOpenMenu(null);
  };

  return (
    <SideNav
      style={{
        backgroundColor: '#000',
        color: '#fff',
        display: 'flex',
        flexDirection: 'column',
        height: '100vh',
        width: isExpanded ? '250px' : '70px',
        transition: 'all 0.3s ease',
        overflowY: 'auto',
        overflowX: 'hidden',
      }}
      onToggle={handleToggle}
      id="sidenav"
    >
      <img
        src="src/assets/dogvilleLogo-removebg.png"
        alt="Logo del sito"
        style={{
          widht: '100%',
          transition: 'all 0.3s ease',
        }}
        className="mx-1"
      />

      <Toggle />
      <div style={{ flex: 1 }} className="mt-5">
        <SideNav.Nav defaultSelected="home">
          <NavItem eventKey="home">
            <NavIcon>
              <i className="fa fa-fw fa-home" style={{ fontSize: 15 }}></i>
            </NavIcon>
            <NavText>Home</NavText>
          </NavItem>

          <NavItem eventKey="about">
            <NavIcon>
              <i className="fa fa-fw fa-address-card" style={{ fontSize: 15 }}></i>
            </NavIcon>
            <NavText>Chi siamo</NavText>
          </NavItem>

          <NavItem eventKey="dogs">
            <NavIcon>
              <i className="fa fa-fw fa-dog" style={{ fontSize: 15 }}></i>
            </NavIcon>
            <NavText>Cani</NavText>
          </NavItem>

          <NavItem eventKey="services" onClick={() => toggleMenu('services')}>
            <NavIcon>
              <i className="fa fa-fw fa-bell-concierge" style={{ fontSize: 15 }}></i>
            </NavIcon>
            <NavText>Servizi</NavText>
          </NavItem>

          {openMenu === 'services' && (
            <>
              <NavItem className="text-start mx-5">
                <NavText>Adotta un cane</NavText>
              </NavItem>
              <NavItem className="text-start mx-5">
                <NavText>Consegna un cane</NavText>
              </NavItem>
              <NavItem className="text-start mx-5">
                <NavText>Studio veterinario H24</NavText>
              </NavItem>
              <NavItem className="text-start mx-5">
                <NavText>Vitto e alloggio</NavText>
              </NavItem>
              <NavItem className="text-start mx-5">
                <NavText>Microchip identificativo</NavText>
              </NavItem>
              <NavItem className="text-start mx-5">
                <NavText>Vaccinazioni e sverminamenti</NavText>
              </NavItem>
              <NavItem className="text-start mx-5">
                <NavText>Parti assistiti</NavText>
              </NavItem>
            </>
          )}

          <NavItem eventKey="cure" onClick={() => toggleMenu('cure')}>
            <NavIcon>
              <i className="fa fa-fw fa-virus-slash" style={{ fontSize: 15 }}></i>
            </NavIcon>
            <NavText>Cure</NavText>
          </NavItem>

          {openMenu === 'cure' && (
            <>
              <NavItem className="text-start mx-5">
                <NavText className="">Vaccini avanzati</NavText>
              </NavItem>
              <NavItem className="text-start mx-5">
                <NavText>Trattamento antipulci</NavText>
              </NavItem>
              <NavItem className="text-start mx-5">
                <NavText>Sterilizzazione e castrazione</NavText>
              </NavItem>
              <NavItem className="text-start mx-5">
                <NavText>Pulizia dentale</NavText>
              </NavItem>
            </>
          )}

          <NavItem eventKey="contacts">
            <NavIcon>
              <i className="fa fa-fw fa-address-book" style={{ fontSize: 15 }}></i>
            </NavIcon>
            <NavText>Contatti</NavText>
          </NavItem>
        </SideNav.Nav>
      </div>

      <div className="pb-10 pt-5 border-solid border-white border-t-2 mt-5">
        <NavItem eventKey="likes" className="mx-5">
          <NavIcon>
            <i className="fa fa-regular fa-heart" style={{ fontSize: 20 }}></i>
          </NavIcon>
        </NavItem>
        <NavItem eventKey="shop" className="mx-5 mt-5">
          <NavIcon>
            <i className="fa fa-solid fa-bag-shopping" style={{ fontSize: 20 }}></i>
          </NavIcon>
        </NavItem>
      </div>
    </SideNav>
  );
}

export default CustomSidebar;
