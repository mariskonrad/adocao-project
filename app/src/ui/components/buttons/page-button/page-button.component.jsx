import './page-button.css'

export function PageButton({ children, onClick, disabled, margin, width, background }) {
  return (
    <button
      className="page-button-content"
      style={{ margin: margin, width: width }}
      onClick={() => onClick()}
      disabled={disabled}
    >
      {children}
    </button>
  )
}
