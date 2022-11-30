import './primary-button.css'

export function PrimaryButton({ text, onClick, isTextBold, margin, width, type }) {
  const buttonClasName = isTextBold ? ' bold' : ''
  return (
    <>
      {onClick ? (
        <button
          type={type}
          onClick={e => onClick(e)}
          className={`primary-button${buttonClasName}`}
          style={{ margin: margin, width: width }}
        >
          {text}
        </button>
      ) : (
        <button
          type={type}
          className={`primary-button${buttonClasName}`}
          style={{ margin: margin, width: width }}
        >
          {text}
        </button>
      )}
    </>
  )
}
