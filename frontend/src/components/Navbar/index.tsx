import {ReactComponent as GithubIcon} from 'assets/img/github.svg';
import './styles.css';
function Navbar(){

    return (
            <header>
            <nav className="container">
            <div className="dsmovie-nav-content">
                <h1>DSmovie</h1>
                <a href="https://github.com/lima6615">
                    <div className="dsmovie-nav-git">
                        <GithubIcon />
                        <p className="dsmovie-contact-link">/lima6615</p>
                    </div>
                </a>
            </div>    
            </nav>
        </header>
     );
}

export default Navbar;